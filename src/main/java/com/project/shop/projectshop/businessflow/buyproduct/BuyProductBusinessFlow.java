package com.project.shop.projectshop.businessflow.buyproduct;

import java.util.List;
import java.util.Optional;

import com.project.shop.projectshop.busibess.product.ProductBusiness;
import com.project.shop.projectshop.model.block.BlockNode;
import com.project.shop.projectshop.model.buyproduct.BuyProductEntity;
import com.project.shop.projectshop.model.buyproduct.requset.BuyProductRequset;
import com.project.shop.projectshop.model.buyproduct.requset.node.BuyNode;
import com.project.shop.projectshop.model.exception.ValidateException;
import com.project.shop.projectshop.model.product.ProductEntity;
import com.project.shop.projectshop.model.product.requset.CreateProductRequest;
import com.project.shop.projectshop.model.user.node.UserNode;
import com.project.shop.projectshop.repository.block.BlockNodeRepository;
import com.project.shop.projectshop.repository.user.UserNodeRepository;
import com.project.shop.projectshop.repository.userbuy.BuyNodeRepository;
import com.project.shop.projectshop.repository.userbuy.BuyProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuyProductBusinessFlow {

    private @Autowired BuyProductRepository buyProductRepositoty;
    private @Autowired ProductBusiness productBusiness;
    private @Autowired BlockNodeRepository blockNodeRepository;
    private @Autowired UserNodeRepository userNodeRepository;
    private @Autowired BuyNodeRepository buyNodeRepository;

    public BuyProductEntity createdLogBuyProduct(Long id, Long userId, BuyProductRequset request)
            throws ValidateException {
        ProductEntity product = productBusiness.getProductByIdOrElseThrowIfNotExist(id);
        validateUnit(request, product);
        BuyProductEntity entity = new BuyProductEntity();
        entity.setUserBy(userId);
        entity.setUserSell(product.getCreatedBy());
        entity.setProductId(id);
        entity.setUnitAmount(request.getUnitAmount());
        entity.setPrice(request.getPrice());
        entity.setIsDeleted(false);
        entity.setCreatedBy(userId);
        entity.setUpdatedBy(userId);
        convertToUpdateProduct(product, userId, request);
        BuyProductEntity productLog = buyProductRepositoty.save(entity);

        // Optional<BlockNode> x = blockNodeRepository.findById(productLog.getCreatedBy());
        // BlockNode blockNode = x.get();
        // Optional<UserNode> userNode = userNodeRepository.findById(userId);
        // Optional<UserNode> userBuy = userNodeRepository.findById(userId);
        // List<UserNode> userNodes = blockNode.getUserNodes();
        // userNodes.add(userNode.get());
        // blockNode.setId(3L);
        // blockNode.setUserNodes(userNodes);

        // BuyNode buyNode = new BuyNode();
        // buyNode.setId(1L);
        // buyNode.setUserBuy(userBuy.get());
        // buyNode.setUserSell(userNode.get());
        // buyNodeRepository.save(buyNode);

        // blockNodeRepository.save(blockNode);
        return productLog;
    }

    public void validateUnit(BuyProductRequset request, ProductEntity product) throws ValidateException {
        if (request.getUnitAmount() > product.getUnitAmount()) {
            throw new ValidateException("จำนวนรายการสินค้าไม่พอ");
        }
    }

    public void convertToUpdateProduct(ProductEntity product, Long userId, BuyProductRequset requestBuy) {
        CreateProductRequest request = new CreateProductRequest();
        Long unitAmount = product.getUnitAmount() - requestBuy.getUnitAmount();
        if ( unitAmount == 0) {
            product.setIsDeleted(true);
        }
        request.setId(product.getId());
        request.setName(product.getName());
        request.setKey(product.getKey());
        request.setDetail(product.getDetail());
        request.setUnitAmount(unitAmount);
        request.setPrice(product.getPrice());
        request.setIsDeleted(product.getIsDeleted());
        productBusiness.saveProduct(request, userId);
    }
}
