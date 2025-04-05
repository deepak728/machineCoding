Parking Lot: 

**Requirements :** 

- There is a parking lot with address and all.
- There will be multiple entries/exit.
- There can be different levels.
- It will be able to park different vehicle (CAR, MOTORCYCLE, VAN, TRUCK)
- It will have different types of parking spot (BIG, MID, SMALL)
- It will have display board ( which show availibility of different types of parking spot)
- It will have a ticketing feature. (Issued at entry and validated at exit)
- Payment can be done via cash/card. Amount will be calculated by hourly rate.
- Rates are different for each type of parking.

**Use case :** 

Customer :

- See display about the availibility
- Collect parking ticket
- Park vehicle
- make the payment and exit.

Admin : 

- Add/remove levels
- Add/remove spots
- login/logout of account
- change pricing

System : 

- Display Data
- Find a parking spot (Closest)
- Assign vehicle
- remove vehicle
- calculate total cost
- accept payment.


**Improvements and extension :** 
- Make code thread safe in case there are multiple servers. 
- Implement Vehicle and ParkingSpot factory. 
- Use builder pattern for Ticket class 
- Use priority queue to get closest parking spot. 
- For unparking take ticket id as input or ticket object. 
- Create different services for different purpose. Follow single responsibility principle. 

