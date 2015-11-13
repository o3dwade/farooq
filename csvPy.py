import csv
import sys
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
	        	pt[idx][0]= arr[idx][0]
			pt[idx][1]= arr[idx][1]		
	p = [0 for x in range(count)]
	for idx in range(len(pt)):
		dataPoint = Point(pt[idx][0],pt[idx][1], None)
		p[idx] = dataPoint
	plt.plot([p])
	plt.show()

	f.close()
class Point:
	def __init__(self, xc, yc,c):
		self.x = xc
		self.y = yc
		self.cluster= c
if __name__=="__main__":
	main()
