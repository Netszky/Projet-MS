package ynov.projetms.comment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ynov.projetms.comment.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

	public default Iterable<Comment> findAllByArticleId(int id) {
		return null;
	}
	
}
