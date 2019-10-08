package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	ProductRepository productRepository;
	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private EntityManager entityManager;

	@Test
	public void contextLoads() {
	}

	@Test
	public void injectedComponentsAreNotNull(){
		Assertions.assertThat(dataSource).isNotNull();
		Assertions.assertThat(jdbcTemplate).isNotNull();
		Assertions.assertThat(entityManager).isNotNull();
		Assertions.assertThat(productRepository).isNotNull();
		Assertions.assertThat(reviewRepository).isNotNull();
		Assertions.assertThat(commentRepository).isNotNull();

	}

	@Test
	public void testCreateProduct(){

		//Create product
		Product product = new Product();

		//set the attributes
		product.setProductName("Iphone");
		product.setProductCount(2);

		//save the product
		entityManager.persist(product);

		//get the product by id
		Optional<Product> actual = productRepository.findById(product.getProductId());
		if(actual.isPresent()){
			assertThat(actual).isNotNull();
		}

		//test if product is not null
		assertThat(actual).isNotNull();

		//test to get product by id
		assertEquals(product.getProductId(),actual.get().getProductId());
	}

	@Test
	public void testCreateReview(){

		//Create product
		Product product = new Product();

		//set the attributes
		product.setProductName("Iphone");
		product.setProductCount(2);

		//save the product
		entityManager.persist(product);



		//get the product by id
		Optional<Product> productRepo = productRepository.findById(product.getProductId());

		if(productRepo.isPresent()){
			assertThat(productRepo).isNotNull();
		}
		//test if product is not null
		assertThat(productRepo).isNotNull();

		//create review
		Review review = new Review();
		//set the attributes
		review.setReviewText("My first IphonePhone");
		review.setProduct(productRepo.get());


		entityManager.persist(review);

		//get review by ID from repository
		Optional<Review> reviewRepo = reviewRepository.findById(review.getReviewId());
		if(reviewRepo.isPresent()){
			assertThat(reviewRepo).isNotNull();
		}
		//test if review is not null
		assertThat(reviewRepo).isNotNull();

		//test review created for product
		assertEquals(review.getProduct(),reviewRepo.get().getProduct());
	}

	@Test
	public void testCreateComment(){

		//Create product
		Product product = new Product();

		//set the attributes
		product.setProductName("Iphone");
		product.setProductCount(2);

		//save the product
		entityManager.persist(product);

		//get the product by id
		Optional<Product> productRepo = productRepository.findById(product.getProductId());

		if(productRepo.isPresent()){
			assertThat(productRepo).isNotNull();
		}

		//test if product is not null
		assertThat(productRepo).isNotNull();

		//create review
		Review review = new Review();
		//set the attributes
		review.setReviewText("My first IphonePhone");
		review.setProduct(productRepo.get());

		entityManager.persist(review);

		//get review By Id
		Optional<Review> reviewRepo = reviewRepository.findById(review.getReviewId());
		if(reviewRepo.isPresent()){
			assertThat(reviewRepo).isNotNull();
		}
		//test if review is not null
		assertThat(reviewRepo).isNotNull();

		//create comment
		Comment comment = new Comment();

		//set the attribute
		comment.setCommentText("Congratulations");
		comment.setReview(reviewRepo.get());

		entityManager.persist(comment);

		//get comment by Id
		Optional<Comment> commentRepo = commentRepository.findById(comment.getCommentId());
		if(commentRepo.isPresent()){
			assertThat(commentRepo).isNotNull();
		}
		//test if comment is not null
		assertThat(commentRepo).isNotNull();
		//test comment created for review
		assertEquals(comment.getReview(),commentRepo.get().getReview());
	}

}