package com.psbc.canteen.common.utils.api;



import com.psbc.canteen.common.utils.InterfacePage;

import java.io.Serializable;



public interface IBaseService<T, PK extends Serializable>{

	/**
	 *<pre>
	 * 说       明: 添加数据
	 * @param entity
	 * @return
	 * @throws Exception
	 * 涉及版本: 
	 * 日       期: 2015-9-7上午10:48:26
	 *</pre>
	 */
	public String insert(T entity) throws Exception;

	/**
	 *<pre>
	 * 说       明: 修改数据
	 * @param entity
	 * @return
	 * @throws Exception
	 * 涉及版本: 
	 * 日       期: 2015-9-7上午10:48:32
	 *</pre>
	 */
	public Integer update(T entity) throws Exception;
	
	/**
	 *<pre>
	 * 说       明: 分页查询
	 * @param entity
	 * @param page
	 * @return
	 * @throws Exception
	 * 涉及版本: 
	 * 日       期: 2015-9-7上午10:48:36
	 *</pre>
	 */
	public InterfacePage findPage(T entity, InterfacePage<T> page) throws Exception;
	
	/**
	 *<pre>
	 * 说       明: 查询某一条数据
	 * @param entity
	 * @return
	 * @throws Exception
	 * 涉及版本: 
	 * 日       期: 2015-10-15上午10:31:09
	 *</pre>
	 */
	public T findOne(T entity) throws Exception;
	
	/**
	 *<pre>
	 * 说       明: 查询某一条数据
	 * @param id
	 * @return
	 * @throws Exception
	 * 涉及版本: 
	 * 日       期: 2015-10-15上午10:31:09
	 *</pre>
	 */
	public T findById(PK id) throws Exception;
}
