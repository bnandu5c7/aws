create DATABASE Ride;
use Ride;
create table rideDetails(RideNo int  Primary key AUTO_INCREMENT,DriverName varchar(40),CustomerName varchar(45),PassengerCount int(6));
insert into rideDetails(DriverName,CustomerName,PassengerCount) values("karan","rohan",4);
insert into rideDetails(DriverName,CustomerName,PassengerCount) values("rahul","nandini",5);
insert into rideDetails(DriverName,CustomerName,PassengerCount) values("kishore","shrinika",2);
insert into rideDetails(DriverName,CustomerName,PassengerCount) values("arunsh","deeksha",3);
select *from rideDetails;