create table `order` (
  id bigint not null auto_increment,
  contact bigint,
  name varchar(255),
  note varchar(255),
  subtotal_amount double precision,
  tax_amount double precision,
  total_amount double precision,
  primary key (id)
)