create database inventario;
  use inventario;

  create table legend (
    idlegend int not null auto_increment,
    sentido varchar(50),
    color  varchar(30)
    )ENGINE=INNODB;


  create table warehouse (
    idwarehouse int not null auto_increment,
    nombrewarehouse varchar(50),
    min int,
    max  int
    )ENGINE=INNODB;


  create table products (
    idproducts int not null auto_increment,
    nombreproducts varchar(50),
    total int,
    idwarehouse int,
    restante  int,
    foreign key (idwarehouse) references warehouse(idwarehouse) on delete cascade
    )ENGINE=INNODB;


salida

select a.nombreproducts, a.onStock, a.Sold, a.total, a.nombrewarehouse, case
    when w.min < a.onStock then l.color = "red"
    whenw.min > a.onStock l.color = "yellow"
    ELSE l.color = "green"
END
from (
select p.nombreproducts, p.restante as onStock, p.total - p.restante as Sold, p.total, w.nombrewarehouse, w.min
        from products p 
inner join p.idwarehouse = warehouse w on p.idwarehouse = w.idwarehouse
order by a.nombreproducts, a.onStock, a.Sold, a.total, a.nombrewarehouse
) a, legend l;



create or replace view InventoryOutput as 
  select a.nombreproducts, a.onStock, a.Sold, a.total, a.nombrewarehouse, case
    when w.min < a.onStock then l.color = "red"
    whenw.min > a.onStock l.color = "yellow"
    ELSE l.color = "green"
END
from (
select p.nombreproducts, p.restante as onStock, p.total - p.restante as Sold, p.total, w.nombrewarehouse, w.min
        from products p 
inner join p.idwarehouse = warehouse w on p.idwarehouse = w.idwarehouse
order by a.nombreproducts, a.onStock, a.Sold, a.total, a.nombrewarehouse
) a, legend l;
