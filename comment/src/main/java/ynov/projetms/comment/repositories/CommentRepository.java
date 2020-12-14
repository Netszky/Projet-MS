package ynov.projetms.comment.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ynov.projetms.comment.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

	public default Iterable<Comment> findAllByArticleId(int id) {
		Iterable<Comment> allComments = this.findAll();
		List<Comment> articleComments = new ArrayList<Comment>();
		for (Comment c: allComments) {
			if (c.getOn_article_id().equals(id)) {
				articleComments.add(c);
			}
		}
		return articleComments;
	}
	
}
