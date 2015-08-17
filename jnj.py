
import sys

#script, net_worth, growth, years = argv

net_worth=float(sys.argv[1])
growth=float(sys.argv[2])
years=int(sys.argv[3])

print "The net worth is:", net_worth
print "The growth is:", growth
print "The years of growth is:", years

sum=0
for x in range (0, years):
    print "Value for year: ", x, " is ", net_worth
    net_worth=((net_worth*(growth/100)))+net_worth

print sum


    
