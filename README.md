# POS
Point of sale system 
GUI - Is the login , it was to late to change from gui to login. 
GUI- needs to be linked to HOMEWIN - JFRAME extends.... or scenes... 
GUI- needs to take in password and username textfield 
Homewin- is the interface for the POS main window. 
Homewin- menutab ( main menu is the pos interface) The report tab should list the history of receipts. 
Homewin- Receipt box should portray list of items, with price
Homewin - jbutton cancel order - should delete everything and start from scratch 
Homewin- jtotal field should add tax and subtotal 
Homewin - jtax field  should calculate total tax ( MAYBE USE MINNESOTAS TAX RPERCENTAGE?)
Homewin- the images of groceries are jbuttons... we need to add item amount somehow and link it to the receipt box. 


SOS Project RequirementsPoint of Sale System is developed to support supermarket-type store operations. In particular software shall:
1.   Allow the cashier to start a new sale and allow add/remove items to a new sale.
2.   Once all items are added to the sale the cashier can request for cash for finishing up the sale.
3.   Keep track of the amount of sales ($) at each register for each cashier.  
4.   Each sales register will record the register number, the user (cashier), the dates and times of sale, and the amount of sales.
5.   Keep track of the "drawer" for each cashier on duty.    The "drawer" keeps track of the total amount of sales made by a single cashier during the entire shift. 
6.   Support cancellation of the entire sale as well as return of an individual item.
7.   Keep track of the inventory, including quantity, price, supplier, and outstanding orders.Example of inventory: subtract number of items sold from the master file which should contain items on hand.
8.   Support inventory management (add/remove item to/from inventory, setting threshold for re-ordering.)
9.   Support report generation:
?Inventory report (listing off al inventory items with name, quantity, threshold, supplier, and quantity of items in pending orders.)
?Cashier report (listing of all assignment records, all register records, all discrepancy records.)
?Register report (listing of all register records, all assignment records.)