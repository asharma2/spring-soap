package org.spring.soap.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.article.AddArticleRequest;
import com.concretepage.article.AddArticleResponse;
import com.concretepage.article.ArticleInfo;
import com.concretepage.article.DeleteArticleRequest;
import com.concretepage.article.DeleteArticleResponse;
import com.concretepage.article.GetAllArticlesResponse;
import com.concretepage.article.GetArticleByIdRequest;
import com.concretepage.article.GetArticleByIdResponse;
import com.concretepage.article.ServiceStatus;
import com.concretepage.article.UpdateArticleRequest;
import com.concretepage.article.UpdateArticleResponse;

@Endpoint
public class ArticleEndpoint {
	private static final String NAMESPACE_URI = "http://www.concretepage.com/article";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getArticleByIdRequest")
	@ResponsePayload
	public GetArticleByIdResponse getArticle(@RequestPayload GetArticleByIdRequest request) {
		GetArticleByIdResponse response = new GetArticleByIdResponse();
		ArticleInfo articleInfo = new ArticleInfo();
		response.setArticleInfo(articleInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllArticlesRequest")
	@ResponsePayload
	public GetAllArticlesResponse getAllArticles() {
		GetAllArticlesResponse response = new GetAllArticlesResponse();
		List<ArticleInfo> articleInfoList = new ArrayList<>();
		response.getArticleInfo().addAll(articleInfoList);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addArticleRequest")
	@ResponsePayload
	public AddArticleResponse addArticle(@RequestPayload AddArticleRequest request) {
		AddArticleResponse response = new AddArticleResponse();
		ServiceStatus serviceStatus = new ServiceStatus();
		ArticleInfo article = new ArticleInfo();
		article.setTitle(request.getTitle());
		article.setCategory(request.getCategory());
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateArticleRequest")
	@ResponsePayload
	public UpdateArticleResponse updateArticle(@RequestPayload UpdateArticleRequest request) {
		ArticleInfo article = new ArticleInfo();
		BeanUtils.copyProperties(request.getArticleInfo(), article);
		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Content Updated Successfully");
		UpdateArticleResponse response = new UpdateArticleResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteArticleRequest")
	@ResponsePayload
	public DeleteArticleResponse deleteArticle(@RequestPayload DeleteArticleRequest request) {
		ArticleInfo article = new ArticleInfo();
		ServiceStatus serviceStatus = new ServiceStatus();
		DeleteArticleResponse response = new DeleteArticleResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}
}
