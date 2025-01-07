package com.fmg.example1.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	//select * from prodtab where prod_code=prodCode;
	Product findByProdCode(String prodCode);

	//select * from prodtab where prod_code like prodCode
	List<Product> findByProdCodeLike (String pc);

	//select * from prodtab where prod_code is null
	List<Product> findByProdCodeIsNull();

	//select * from prodtab where prod_cost=cost
	List<Product> findByProdCostGreaterThan(Double cost);

	//select * from prodtab where prod_cost in (cost)
	List<Product> findByProdCostIn(Collection<Double> costs);

	//select * from prodTab where pid=? Or pcost=?
	List<Product> findByProdIdOrProdCost(Integer pid, Double cost);

	//select * from prodtab where pid between pid1 and pid2
	List<Product> findByProdIdBetween (Integer pid1, Integer pid2);

	//this will not work just for example as vendor is not there
	//Select * from prodtab where pid<=? And pcost>=? And prodCode is not null order by pcode;
	List<Product> findByProdIdLessThanAndProdCostGreaterThanAndProdCodeNotNullOrderByProdCode(Integer prodId, Double prodCost);

}
