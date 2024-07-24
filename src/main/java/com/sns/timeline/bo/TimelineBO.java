package com.sns.timeline.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.comment.bo.CommentBO;
import com.sns.comment.domain.CommentView;
import com.sns.post.bo.PostBO;
import com.sns.post.entity.PostEntity;
import com.sns.timeline.domain.CardView;
import com.sns.user.bo.UserBO;
import com.sns.user.entity.UserEntity;

@Service
public class TimelineBO {
	
	@Autowired
	private PostBO postBO;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private CommentBO commentBO;

	// input:X    output: List<CardView>
	public List<CardView> generateCardViewList() {
		List<CardView> cardViewList = new ArrayList<>();
		
		// 글목록을 가져온다. List<PostEntity>
		List<PostEntity> postList = postBO.getPostEntityList();
		
		// 글목록 반복문 순회
		// PostEntity => CardView     -> cardViewList에 넣기
		for (PostEntity post : postList) {
			CardView card = new CardView();
			
			// 글
			card.setPost(post);
			
			// 글쓴이
			UserEntity user = userBO.getUserEntityById(post.getUserId());
			card.setUser(user);
			
			// 댓글 N개
			List<CommentView> commentViewList = commentBO.generateCommentViewListByPostId(post.getId());
			// 댓글을 카드에 넣는다.
			card.setCommentList(commentViewList);
			
			// 좋아요 개수
			
			// 좋아요 여부 채우기
			// card.setFilledLike(likeBO.filledLikeByPostIdUserId(post.getId(),userId));
			
			
			
			// input: postId(필수), userId(로그인/비로그인)
			// output: boolean (채울지 여부)
			/*
			 * public boolean filledLikeByPostIdUserId(int postId, Integer userId) { //
			 * 비로그인이면 DB조회 없이 하트 채우지 않음 if (userId == null) { return false; }
			 * 
			 * // 로그인이면 1) 행이 있으면(1인경우) true 2) 행이 없으면 (0인경우) false return
			 * likeMapper.selectLikeCountByPostIdUserId(postId, userId) == 1 ? true : false
			 * ; }
			 */
			
			//!!!!!!!!! 반드시 리스트에 넣는다.
			cardViewList.add(card);
		}
		
		return cardViewList;
	}
}