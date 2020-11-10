# LibraryStorage
> LibraryStorage is a school project that we have created. The project aim is to make a library that stores books and movies that customers are allowed to borrow.
 
## Table of contents
* [General info](#general-info)
* [Instructions](#instructions)
* [Technologies](#technologies)
* [Setup](#setup)
* [Status](#status)
* [Source](#source)
* [Contact](#contact)

## General info
Library storage is a console application that stores products as books and movies. As a customer, you can borrow, return, register and deregister the products as you wish.

## Instructions
The program starts by showing the current inventory. It shows the article number of the products, which you can use as identification of the specific product you want to handle when typing in commands. You can then enter one of these commands: list, checkout, checkin, register, deregister, info, and quit. 
* The "list" command shows you the current inventory. 
* The "checkout" command + an article number of an existing product, opens a dialog that lets you enter a name and phonenumber of the customer borrowing this product. The product will be unavailable after this checkout.
* The "checkin" command + an article number of an existing product that has been borrowed by a customer, removes the customer and makes the product available again.
* The "register" command lets you create a product and add it to the inventory. It will open up a dialog that lets you type in the product type ("Movie" or "Book"), article number (an int), title (name of product), price (price in swedish krona in int), and then, depending on the product type, length in minutes (an int) , IMDB rating (a double value up to 10.0), amount of pages (an int), and author (a name). The values need to be separated by a ";" without spacing.
For example: Movie;1234;V for Vendetta;120;132;8.2
* The "deregister" command + an article number of an existing product, will remove the product from the inventory.
* The "info" command + an article number of an existing product, will show the full info about the product you have chosen.
* The "quit" command stops the application.



## Technologies
> Java - 2020

## Setup 
In the repository you have access to the csv file that contains the products, setting, bin and src folders to get our code so you can try it in your IDE. 

## Status
This is a school project that will be examined by our teacher. We might change the code in the near future.

## Source
This tutorial helped us move forward while coding this project. The video shows how to remove records from a csv.file which we had some struggle with.
https://www.youtube.com/watch?v=NceIYifVAQQ

## Contact
Sena Abdul Hussein: senaabdulhussein@gmail.com
Thitisuda Mahasrithanet: thiti.90@gmail.com
