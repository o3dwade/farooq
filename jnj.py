
import sys

#script, net_worth, growth, years = argv

fcf=float(sys.argv[1])
growth=float(sys.argv[2])
years=int(sys.argv[3])

print "The free cash flow is:", fcf
print "The growth is:", growth
print "The years of growth is:", years

oldfcf=fcf
gp=growth/100
sum=float(0)
for x in range (0, years):
    if x>=10:
        gp = .05
    sum=sum+(fcf/((1+.15)**x))
    print "Projected FCF for year: ", x+2006, " is ", '{0:.5g}'.format(fcf)#, " PV is: ", '{0:.5g}'.format(sum)
    fcf=((fcf*(gp)))+fcf

value=sum-oldfcf+39000
value=value/2900

print "The value is: ", '{0:.8}'.format(value)


    
