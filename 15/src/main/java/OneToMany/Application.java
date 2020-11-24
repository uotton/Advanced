package OneToMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Application {

	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		config.configure("/META-INF/hibernate.cfg.xml");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		Session session = config.buildSessionFactory(serviceRegistry).openSession();

		Post post = new Post();
		post.setTitle("title of post");
		
		Comment comment = new Comment();
		comment.setAuthorName("authorName1");
		
		Comment comment2 = new Comment();
		comment2.setAuthorName("authorName2");
		
		Set<Comment> commentSet = new HashSet<>();
		commentSet.add(comment);
		commentSet.add(comment2);

		post.setComments(commentSet);;

		
		Transaction transaction = session.beginTransaction();
		session.save(post);
		transaction.commit();
		
		
		//read
		Post postDB = (Post) session.get(Post.class, 1);
		System.out.println(postDB + "---->" + postDB.getTitle());

		Comment commentDB = (Comment) session.get(Comment.class, 2);
		System.out.println(commentDB + "---->" + commentDB.getAuthorName());

	}
                 	
}
