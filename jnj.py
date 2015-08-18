
import sys

#script, net_worth, growth, years = argv

fcf=float(sys.argv[1])
growth=float(sys.argv[2])
years=int(sys.argv[3])

print "The free cash flow is:", fcf
print "The growth is:", growth
print "The years of growth is:", years

gp=growth/100
sum=0
for x in range (0, years):
    print "Value for year: ", x, " is ", fcf
    fcf=((fcf*(gp)))+fcf
    sum=sum+fcf/((1+gp)**years)

print "The PC sum is: ", sum


    
