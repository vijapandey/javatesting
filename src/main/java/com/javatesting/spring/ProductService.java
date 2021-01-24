package com.javatesting.spring;

import java.util.Collection;

import com.javatesting.simple.ModelClass;

public interface ProductService {

	public abstract void createProduct(ModelClass product);

	public abstract void updateProduct(Integer id, ModelClass product);

	public abstract void deleteProduct(Integer id);

	public abstract Collection<ModelClass> getProducts();

}
