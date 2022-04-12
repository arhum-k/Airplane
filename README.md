# Airplane

In this Airplane program, there is a text file of 76 names, which are later converted to Passenger objects, but only 50 can fit on a plane. The code selects the first 50 people on the list and adds it to a 2D array which is used to display the airplane seating chart. From there, the user has the option to 1) add passenger, 2) remove passenger, 3) clear a column and replace passengers with people on the waiting list, 4) display seating chart, 5) display waiting list, or 6) quit . If the user selects 1, a new Passenger object is created and added to the waiting list based on the inputted name, if the user selects 2, a passenger is removed and replaced with the first person on the waiting list, and selecting 3 does this to an entire column. The rest of the options are self explanatory. In order to read the text file, I used the BUfferReader class to read through each of line and add each Passenger to a list of Passengers. At the very end, when the user selects 6 (quit), the final seating chart and watilst are displayed. 

Console:


![Screen Shot 2022-04-12 at 3 09 31 PM](https://user-images.githubusercontent.com/72320993/163063038-057fb412-8137-472e-82ba-2acf879be630.png)

![Screen Shot 2022-04-12 at 3 09 48 PM](https://user-images.githubusercontent.com/72320993/163063051-8971bffc-5460-4ca6-aab7-74206194f5df.png)

![Screen Shot 2022-04-12 at 3 09 57 PM](https://user-images.githubusercontent.com/72320993/163063058-4232e757-5c5e-424c-8847-faf413ef84da.png)

![Screen Shot 2022-04-12 at 3 10 07 PM](https://user-images.githubusercontent.com/72320993/163063063-c0fa37ba-bbf5-4c76-818d-826b2b46a3b0.png)
