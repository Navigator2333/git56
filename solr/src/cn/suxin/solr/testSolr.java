package cn.suxin.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
import org.junit.Test;

public class testSolr {
	@Test
	public void testCreateAndUpdateIndex() throws Exception {
		// 1. 创建HttpSolrServer对象
		// 设置solr服务接口,浏览器客户端地址http://127.0.0.1:8081/solr/#/
		String baseURL = "http://127.0.0.1:8080/solr";
		HttpSolrServer httpSolrServer = new HttpSolrServer(baseURL);
		// 2. 创建SolrInputDocument对象
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "c1002");
		document.addField("content111", "测试名称22222");
		// 3. 把SolrInputDocument对象添加到索引库中
		httpSolrServer.add(document);
		// 4. 提交
		httpSolrServer.commit();
	}
	
	@Test
	public void testQuery() throws Exception {
		String baseURL = "http://127.0.0.1:8080/solr";
		HttpSolrServer httpSolrServer = new HttpSolrServer(baseURL);
		
		SolrQuery params = new SolrQuery();
		SolrQuery query = params.setQuery("*:*");
				
		QueryResponse response = httpSolrServer.query(params);
		SolrDocumentList results = response.getResults();
		for (SolrDocument solrDocument : results) {
			Object id = solrDocument.get("id");
			Object name = solrDocument.get("name");
			System.out.println("id:"+id+",name:"+name);
			System.out.println("测试第二次提交");
			System.out.println("测试第三次提交");
			System.out.println("测试第四次提交");
		}
		
	}

}
