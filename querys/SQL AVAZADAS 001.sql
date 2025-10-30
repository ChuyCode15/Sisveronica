use jugos_ventas;

/*CANTIDAD vENDIDA POR Sber año 2016*/
select P.SABOR, SUM(IFa.CANTIDAD) AS CANTIDAD_TOTAL, year(F.FECHA_VENTA) AS AÑO 
from tabla_de_productos P
inner join items_facturas IFa
on P.CODIGO_DEL_PRODUCTO = IFa.CODIGO_DEL_PRODUCTO
inner join facturas F
on F.NUMERO = IFa.NUMERO 
WHERE year(F.FECHA_VENTA) = 2016 
group by P.SABOR, year(F.FECHA_VENTA)
order by SUM(IFa.CANTIDAD) DESC ;

/* otro */

select SUM(IFa.CANTIDAD) AS CANTIDAD_TOTAL, year(F.FECHA_VENTA) AS AÑO 
from tabla_de_productos P
inner join items_facturas IFa
on P.CODIGO_DEL_PRODUCTO = IFa.CODIGO_DEL_PRODUCTO
inner join facturas F
on F.NUMERO = IFa.NUMERO 
WHERE year(F.FECHA_VENTA) = 2016 
group by year(F.FECHA_VENTA);

/* otro mas complicado */

select * from (
select P.SABOR, SUM(IFa.CANTIDAD) AS CANTIDAD_TOTAL, year(F.FECHA_VENTA) AS AÑO 
from tabla_de_productos P
inner join items_facturas IFa
on P.CODIGO_DEL_PRODUCTO = IFa.CODIGO_DEL_PRODUCTO
inner join facturas F
on F.NUMERO = IFa.NUMERO 
WHERE year(F.FECHA_VENTA) = 2016 
group by P.SABOR, year(F.FECHA_VENTA)
order by SUM(IFa.CANTIDAD) DESC ) as ventas_sabor
inner join (
select SUM(IFa.CANTIDAD) AS CANTIDAD_TOTAL, year(F.FECHA_VENTA) AS AÑO 
from tabla_de_productos P
inner join items_facturas IFa
on P.CODIGO_DEL_PRODUCTO = IFa.CODIGO_DEL_PRODUCTO
inner join facturas F
on F.NUMERO = IFa.NUMERO 
WHERE year(F.FECHA_VENTA) = 2016 
group by year(F.FECHA_VENTA)) as total_ventas_por_año
on total_ventas_por_año.AÑO = ventas_sabor.AÑO ;

/* uno mas con porcentajes de total anual de busqueda*/


select ventas_sabor.SABOR, ventas_sabor.AÑO, ventas_sabor.CANTIDAD_TOTAL, 
round((ventas_sabor.CANTIDAD_TOTAL/total_ventas_por_año.CANTIDAD_TOTAL) * 100, 2)
as PORCENTAJE
from (
select P.SABOR, SUM(IFa.CANTIDAD) AS CANTIDAD_TOTAL, year(F.FECHA_VENTA) AS AÑO 
from tabla_de_productos P
inner join items_facturas IFa
on P.CODIGO_DEL_PRODUCTO = IFa.CODIGO_DEL_PRODUCTO
inner join facturas F
on F.NUMERO = IFa.NUMERO 
WHERE year(F.FECHA_VENTA) = 2016 
group by P.SABOR, year(F.FECHA_VENTA)
order by SUM(IFa.CANTIDAD) DESC ) as ventas_sabor
inner join (
select SUM(IFa.CANTIDAD) AS CANTIDAD_TOTAL, year(F.FECHA_VENTA) AS AÑO 
from tabla_de_productos P
inner join items_facturas IFa
on P.CODIGO_DEL_PRODUCTO = IFa.CODIGO_DEL_PRODUCTO
inner join facturas F
on F.NUMERO = IFa.NUMERO 
WHERE year(F.FECHA_VENTA) = 2016 
group by year(F.FECHA_VENTA)) as total_ventas_por_año
on total_ventas_por_año.AÑO = ventas_sabor.AÑO 
order by ventas_sabor.CANTIDAD_TOTAL desc;

/*RETO TEHOTIA HABER QUE PASHA */


select ventas_tamaño.TAMANO, ventas_tamaño.AÑO, ventas_tamaño.CANTIDAD_TOTAL, 
round((ventas_tamaño.CANTIDAD_TOTAL/total_ventas_por_año.CANTIDAD_TOTAL) * 100, 2)
as PORCENTAJE
from (
select P.TAMANO, SUM(IFa.CANTIDAD) AS CANTIDAD_TOTAL, year(F.FECHA_VENTA) AS AÑO 
from tabla_de_productos P
inner join items_facturas IFa
on P.CODIGO_DEL_PRODUCTO = IFa.CODIGO_DEL_PRODUCTO
inner join facturas F
on F.NUMERO = IFa.NUMERO 
WHERE year(F.FECHA_VENTA) = 2016 
group by P.TAMANO, year(F.FECHA_VENTA)
order by SUM(IFa.CANTIDAD) DESC ) as ventas_tamaño
inner join (
select SUM(IFa.CANTIDAD) AS CANTIDAD_TOTAL, year(F.FECHA_VENTA) AS AÑO 
from tabla_de_productos P
inner join items_facturas IFa
on P.CODIGO_DEL_PRODUCTO = IFa.CODIGO_DEL_PRODUCTO
inner join facturas F
on F.NUMERO = IFa.NUMERO 
WHERE year(F.FECHA_VENTA) = 2016 
group by year(F.FECHA_VENTA)) as total_ventas_por_año
on total_ventas_por_año.AÑO = ventas_tamaño.AÑO 
order by ventas_tamaño.CANTIDAD_TOTAL desc;

