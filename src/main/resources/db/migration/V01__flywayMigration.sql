create table product (
    product_id int not null AUTO_INCREMENT,
    product_name varchar(100) not null,
    product_count int not null,
    constraint product_pk primary key (product_id)
);

create table reviews (
    review_id int not null AUTO_INCREMENT,
    review_product_id int  not null,
    review_text varchar(100) not null,
    constraint reviews_pk primary key (review_id),
    constraint reviews_product_fk foreign key(review_product_id) references product (product_id)
);

create table comments (
    comment_id INT not null AUTO_INCREMENT,
    comment_review_id int  not null,
    comment_text varchar(100) not null,
    constraint comment_pk primary key (comment_id),
    constraint comments_review_fk foreign key(comment_review_id) references reviews (review_id)
);

