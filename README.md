# Monte Carlo Integrator

## This program lets you find approximate values for definite integrals up to an arbitrary number of variables.

In order to use this please enter "integrate" on the command line to start the integrals.
Follow this up with the integrand. Use all caps shorthand names for trig functions with their
arguments within parentheses to the immediate right of them.

Follow this with three numbers each separated by a space.
The first being the min for the range of the function, then the max for the range 
of the function, and lastly an integer number of points to use in the integration.
Note that if the range is not appropriately chosen, ie. close the the actual range 
of the function over the desired interval the integrand will be very inaccurate, this is the 
biggest weakness of this monte carlo integrator but it is a common one. 

Another determinate of the accuracy of an integration is the number of points used in the 
approximation, the more used the more accurate however this will take much more time. The smaller
the range and domains are the fewer points that are needed to get an accurate result.

Next enter the list of variables each separated by a space. The order must be paired with the order of
desired domains of integration for each variable given, ie. in the same order.

Next enter the domains for each variable separated by a space where the min and 
max are separated by a space as well.


## Examples to try

integrate       (this starts the integral)  
x + 1           (this is the integrand)  
0 100 100000      
(this sets the min of the range to 0, the max to 100, and the number of points to use to 100000)  
x               (this sets x as a variable to integrate over)  
0 99            (this sets the domain to integrate over to "(0,99)")  

integrate  
SIN(x)/x    (an integral that is impossible to do by hand but we can approximate using this application)  
0 1 100000  
x  
0 20  

integrate  
x*y*z/a   
0 1000 10000  
x y z a  
0 10 0 2 0 4 0 5 (this sets each domain to go from 0 to a different number)  

