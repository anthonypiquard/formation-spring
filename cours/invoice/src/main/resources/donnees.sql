
INSERT INTO INVOICE (ORDER_NUMBER,ID_CUSTOMER) VALUES
  ('AA123456789A',1),
  ('AA123456789B',2),
  ('BB123456789A',3),
  ('AA123456789D',4);

INSERT INTO INVOICE_LINE (ID_PRODUCT,QUANTITY,INVOICE_NUMBER) VALUES
  (1,10,(select INVOICE_NUMBER from INVOICE where ORDER_NUMBER='AA123456789A')),
  (2,1,(select INVOICE_NUMBER from INVOICE where ORDER_NUMBER='AA123456789A')),
  (3,1,(select INVOICE_NUMBER from INVOICE where ORDER_NUMBER='AA123456789B')),
  (4,22,(select INVOICE_NUMBER from INVOICE where ORDER_NUMBER='BB123456789A')),
  (5,2,(select INVOICE_NUMBER from INVOICE where ORDER_NUMBER='BB123456789A')),
  (6,5,(select INVOICE_NUMBER from INVOICE where ORDER_NUMBER='AA123456789D'));