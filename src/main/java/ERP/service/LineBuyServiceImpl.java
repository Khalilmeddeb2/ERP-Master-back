package ERP.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ERP.dto.LineBuyDto;
import ERP.dto.PurchaseOrderDto;
import ERP.model.BuyLineEntity;
import ERP.model.ProductEntity;
import ERP.model.PurchaseOrderEntity;
import ERP.repository.LineBuyRepository;
import ERP.repository.ProductRepository;
import ERP.repository.PurchaseOrderRepository;
@Service
public class LineBuyServiceImpl implements LineBuyService {
	private LineBuyRepository repoLineBuy;
	private ProductRepository repoProduct;
	private PurchaseOrderRepository repoPurchaseOrder;
	private ModelMapper mapper;
	
	@Autowired
	public LineBuyServiceImpl(LineBuyRepository repoLineBuy,ProductRepository repoProduct,
			PurchaseOrderRepository repoPurchaseOrder,ModelMapper mapper)
	{
		this.repoLineBuy=repoLineBuy;
		this.repoProduct=repoProduct;
		this.repoPurchaseOrder=repoPurchaseOrder;
		this.mapper=mapper;
		
	}

	@Override
	public LineBuyDto createLineBuy(LineBuyDto lineBuy, int idProduct, int purchaseNumber) {
		//TODO Auto-generated method stub
		BuyLineEntity entity = mapper.map(lineBuy, BuyLineEntity.class);
		ProductEntity product = repoProduct.findById(idProduct).get();
		PurchaseOrderEntity purchaseOrder = repoPurchaseOrder.findById(purchaseNumber).get();
		entity.setPurchaseOrder(purchaseOrder);
		entity.setProduct(product);
		BuyLineEntity newBuyLine = repoLineBuy.save(entity);
		return mapper.map(newBuyLine, LineBuyDto.class);
	}

	@Override
	public List<LineBuyDto> getAllLineBuy() {
		// TODO Auto-generated method stub
		List<LineBuyDto> listLineBuyDto = new ArrayList<>();
		List<BuyLineEntity>listLineBuyEntity = repoLineBuy.findAll();
		for (BuyLineEntity entity : listLineBuyEntity) {
			listLineBuyDto.add(mapper.map(entity, LineBuyDto.class));
		}
		
		return listLineBuyDto;
	}

	@Override
	public LineBuyDto getLineById(int id) {
		// TODO Auto-generated method stub
		BuyLineEntity entity = repoLineBuy.findById(id).get();
		
		
		return mapper.map(entity, LineBuyDto.class);
	}

	@Override
	public LineBuyDto modifyLineBuy(int id, LineBuyDto newlineBuy) {
		// TODO Auto-generated method stub
		BuyLineEntity entity = mapper.map(newlineBuy, BuyLineEntity.class);
		BuyLineEntity oldLineBuy = repoLineBuy.findById(id).get();
		if(newlineBuy.getDescription()!=null)
			oldLineBuy.setDescription(newlineBuy.getDescription());
		if(newlineBuy.getQt()!=0)
			oldLineBuy.setQt(newlineBuy.getQt());
			

		
		
		
		return mapper.map(repoLineBuy.save(oldLineBuy), LineBuyDto.class);
	}

	@Override
	public LineBuyDto deleteLineBuyById(int id) {
		// TODO Auto-generated method stub
		LineBuyDto entity = this.getLineById(id);
		repoLineBuy.deleteById(id);
		return entity;
		 

	}

}
