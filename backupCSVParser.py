import csv
import sys
import random
import math
import matplotlib.pyplot as plt
def main():
	f = open(sys.argv[1], 'rt')
	count=0;
	reader = csv.reader(f, quoting = csv.QUOTE_MINIMAL)
	for idx,row in enumerate(reader):
		#print row
		count= count+1
	arr= [[0 for x in range(3)] for x in range(count)]
	pt = [[0 for x in range(3)] for x in range(count)]
	f = open(sys.argv[1], 'r')
	reader = csv.reader(f, quoting = csv.QUOTE_MINIMAL)
	for idx,row in enumerate(reader):
		arr[idx] = row
		if(len(arr[idx]) > 0):
	        	pt[idx][0]= arr[idx][2]
			pt[idx][1]= arr[idx][3]		
	p = [0 for x in range(count)]
	x_data = [0 for x in range(count)]
	y_data = [0 for x in range(count)]
	cc1 = random.randint(2,6)
	cc2 = random.randint(1,3)
	cc3 = random.randint(2,6)
	cc4 = random.randint(1,3)
	c1 = Point(cc1, cc2, 'bo')
	c2 = Point(cc3, cc4, 'ro')
	for idx in range(len(pt)):
		if (len(arr[idx]) > 0):
			x_data[idx] = arr[idx][0]
			y_data[idx] = arr[idx][1]
			
		dataPoint = Point(pt[idx][0],pt[idx][1], None)
		p[idx] = dataPoint
	for point in p:
		dx = abs(float(point.x)-c1.x)
		dy = abs(float(point.x)-c1.y)
		dx2 = abs(float(point.y)-c2.x)
		dy2 = abs(float(point.y)-c2.y)
		if ((dx-dy)>(dx2-dy2)):
			#print str(dx) + " red"
			#plt.plot(float(point.x),float(point.y),'bo')
			point.cluster = 'bo'
		else:
			#print str(dx) + " blue"
			#plt.plot(float(point.x),float(point.y),'ro')
			point.cluster = 'ro'
	
	
	for point in p:
		if(point.cluster == 'bo'):
			xavg = (float(point.x)+c1.x)/2
			yavg = (float(point.y)+c1.y)/2
			c1.x = xavg
			c1.y = yavg
		else:
			xavg2 =(float(point.x)+c2.x)/2
			yavg2 =(float(point.y)+c2.y)/2
			c2.x = xavg2
			c2.y = yavg2 
	for point in p:
		#print point.cluster
		plt.plot(float(point.x), float(point.y), str(point.cluster))
	plt.plot(cc1,cc2,'b')
	plt.plot(cc3,cc4,'g')
	#plt.plot(x_data, y_data, 'ro')
	plt.axis([0,8,0,5])
	plt.show()
	f.close()
	

class Point:
	def __init__(self, xc, yc,c):
		self.x = xc
		self.y = yc
		self.cluster= c
if __name__=="__main__":
	main()
