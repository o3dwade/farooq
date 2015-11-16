import csv
import sys
import random
import math

k = sys.argv[2]
C = 0
# C is length of file
pt = None
points = None
centroids = None
classes = ["Iris-virginica", "Iris-setosa", "Iris-versicolor"]
ISCount =0
IVCount =0
IECount =0
objFunc=0
actualISC =0
actualIVC =0
actualIEC =0
def main():
	initialize()
	#initial clustering
	assignPointsToCentroids()

	#kmeans
	o_fun=9000
	while(o_fun>0.0001):
		kmeans_func()
		o_fun=objFunc
	findClass()

	'''
	print "                   Actual  Clustered"
	print "Iris-virginica:    "+str(actualIVC) +"      "+str(IVCount)
	print "Iris-setosa:       "+str(actualISC) +"      "+str(ISCount)
	print "Iris-versicolor:   "+str(actualIEC) +"      "+str(IECount)
	accuracy = (actualIVC+actualISC+actualIEC)/(IVCount+ISCount+IECount)
	
	print "                   Iris-virginica:  Iris-setosa:  Iris-versicolor:"
	print "Iris-virginica:    "+str(actualIVC) +"      "+str(IVCount)
	print "Iris-setosa:       "+str(actualISC) +"      "+str(ISCount)
	print "Iris-versicolor:   "+str(actualIEC) +"      "+str(IECount)
	accuracy = (actualIVC+actualISC+actualIEC)/(IVCount+ISCount+IECount)
	print "Accuracy: "+str(accuracy)
'''
	oneone=0
	onetwo=0
	onethe=0
	twoone=0
	twotwo=0
	twothe=0
	theone=0
	thetwo=0
	thethe=0
	for centroid in centroids:
		if (centroid.ob == "Iris-virginica"):
			for point in centroid.pts:
				if(point.id == "Iris-virginica"):
					oneone==oneone+1
				if(point.id == "Iris-setosa"):
					onetwo= onetwo+1
				if(point.id == "Iris-versicolor"):
					onethe=onethe+1

		if (centroid.ob == "Iris-setosa"):
			for point in centroid.pts:
				if(point.id == "Iris-virginica"):
					twoone=twoone+1
				if(point.id == "Iris-setosa"):
					twotwo=twotwo+1
				if(point.id == "Iris-versicolor"):
					twothe=twothe+1

		elif(centroid.ob =="Iris-versicolor"):
			for point in centroid.pts:
				if(point.id == "Iris-virginica"):
					theone=theone+1
				if(point.id == "Iris-setosa"):
					thetwo=thetwo+1
				if(point.id == "Iris-versicolor"):
					thethe=thethe+1

	print "Iris-virginica: A\nIris-setosa: B\nIris-versicolor: C\n"

	print "    A   B   C"
	print "A   "+str(oneone) + "   "+str(onetwo)+"  "+str(onethe)
	print "B   "+str(twoone) + "   "+str(twotwo)+"  "+str(twothe)
	print "C   "+str(theone) + "   "+str(thetwo)+"  "+str(thethe)
	accuracy = float((oneone+twotwo+thethe))/float((oneone+onetwo+onethe+twoone+twotwo+twothe+theone+thetwo+thethe))
	#print "Accuracy: "+str(oneone+twotwo+thethe)+"..."+str(oneone+onetwo+onethe+twoone+twotwo+twothe+theone+thetwo+thethe)+"{0:.2f}".format(accuracy*100)
	print "Accuracy: {0:.2f}".format(accuracy*100) + "%"


	print "Initial clustering"
	print_func('c')
	print "Final clustering"
	print_func('c')





def initialize():
	#fill up centroids
	global centroids
	global actualIVC
	global actualIEC
	global actualISC
	centroids = [0 for x in range(int(k))]
	count=0
	f = open(sys.argv[1],'rt')
	reader = csv.reader(f, quoting = csv.QUOTE_MINIMAL)
	for idx,row in enumerate(reader):
		count=count+1
		#print row
	global C
	C=count

	global points
	points = [0 for x in range(int(C))]

	arr= [[0 for x in range(5)] for x in range(count)]
	global pt
	pt = [[0 for x in range(5)] for x in range(count)]
	f = open(sys.argv[1], 'r')
	reader = csv.reader(f, quoting = csv.QUOTE_MINIMAL)
	for idx,row in enumerate(reader):
		arr[idx] = row
		if(len(arr[idx]) > 0):
	        	pt[idx][0]= arr[idx][0]
			pt[idx][1]= arr[idx][1]
			pt[idx][2]= arr[idx][2]
			pt[idx][3]= arr[idx][3]
			pt[idx][4]= arr[idx][4]
			point = Point(pt[idx][0], pt[idx][1],pt[idx][2],pt[idx][3], None, pt[idx][4])
			points[idx] = point
	#getting rid of random poin that is useless
	del arr[-1]
	for row in arr:
		s =row[4]
		if (s == "Iris-virginica"):
			actualIVC = actualIVC+1
		elif(s == "Iris-versicolor"):
			actualIEC = actualIEC+1
		else:
			actualISC = actualISC +1
	for i in range(int(k)):
		n = random.randint(1,count-1)
		p = points[n]
		sl = p.p1#random.random() + random.randint(2,7)
		sw = p.p2#random.random() + random.randint(2,4)
		pl = p.p3#random.random() + random.randint(3,9)
		pw = p.p4#random.random() + random.randint(0,3)
		centroid = Cluster(i, sl,sw,pl,pw, [], None, 0)
		centroids[i]=centroid
	#getting rid of a random point that doesnt help 
	del points[-1]


def assignPointsToCentroids():
	for point in points:
		min = 9223372036854775807
		tmpp = None
		tmpc = None
		for centroid in centroids:
			dist = (float(centroid.c1) - float(point.p1))**2+(float(centroid.c2) - float(point.p2))**2+(float(centroid.c3)- float(point.p3))**2+(float(centroid.c4)- float(point.p4))**2
			dist = math.sqrt(dist)
			if (dist<=min):
				min = dist
				tmpp = point
				tmpc = centroid
		tmpc.pts.append(tmpp)
		tmpp.cl = str(tmpc.id)
		#print point
def kmeans_func():
	global objFunc
	'''
	for centroid in centroids:
		for i,point in enumerate(centroid.pts):
			tmpC1 = (float(centroid.c1) + float(point.p1))/(i+1)
			tmpC2 = (float(centroid.c2) + float(point.p2))/(i+1)
			tmpC3 = (float(centroid.c3) + float(point.p3))/(i+1)
			tmpC4 = (float(centroid.c4) + float(point.p4))/(i+1)
			objFunc =abs((float(centroid.c1)-tmpC1)+(float(centroid.c2)-tmpC2)+(float(centroid.c3)-tmpC3)+(float(centroid.c4)-tmpC4))
			centroid.c1 = tmpC1
			centroid.c2 = tmpC2
			centroid.c3 = tmpC3
			centroid.c4 = tmpC4
		centroid.pts =[]
	'''
	for centroid in centroids:
		x1 = []
		x2 = []
		x3 = []
		x4 = []
		n = len(centroid.pts)+1
		tmpC1=float(centroid.c1)
		tmpC2=float(centroid.c2)
		tmpC3=float(centroid.c3)
		tmpC4=float(centroid.c4)
		for p in centroid.pts:
			x1.append(float(p.p1))
			x2.append(float(p.p2))
			x3.append(float(p.p3))
			x4.append(float(p.p4))
		v1 = sum(x1)/n
		v2 = sum(x2)/n
		v3 = sum(x3)/n
		v4 = sum(x4)/n
		centroid.c1=v1
		centroid.c2=v2
		centroid.c3=v3
		centroid.c4=v4
		objFunc = math.sqrt((tmpC1-centroid.c1)**2+(tmpC2-centroid.c2)**2+(tmpC3-centroid.c3)**2+(tmpC4-centroid.c4)**2)
		centroid.pts =[]
	assignPointsToCentroids()

def print_func(val):
	if (val == 'p'):
		for point in points:
			print point
	else:
		for centroid in centroids:
			print centroid

def findClass():
	global centroids
	for centroid in centroids:
		maxISE=0
		maxIVE=0
		maxIVA=0
		ISEc=0
		IVEc=0
		IVAc=0
		for cpoint in centroid.pts:
			if(cpoint.id == 'Iris-virginica'):
				IVAc = IVAc+1
			elif(cpoint.id == 'Iris-versicolor'):
				IVEc = IVEc+1
			else:
				ISEc = ISEc+1
		m= max ( IVAc, IVEc, ISEc)
		if (m==IVAc):
			#print "Centroid " + centroid.id + " is Iris-virginica "+str(m)
			centroid.ob = 'Iris-virginica'
			maxIVA=m
		elif(m==IVEc):
			#print "Centroid " + centroid.id + " is Iris-versicolor "+str(m)
			centroid.ob = 'Iris-versicolor'
			maxIVE=m
		else:
			#print "Centroid " + centroid.id + " is Iris-setosa "+str(m)
			maxISE = m
			centroid.ob = 'Iris-setosa'
	global classes
	for i in range(len(centroids)):
		w=0
		j=i+1
		while (j<len(centroids)):
			if (centroids[i].ob == centroids[j].ob):
				if (centroids[i].maxOb>=centroids[j].maxOb):
					for w in range(len(classes)):
						if(classAvail(classes[w])):
							centroids[j].ob = classes[w]
							#print "huh2 " + str(w) +"!" +classes[w]

				else:
					for w in range(len(classes)):
						if(classAvail(classes[w])):
							centroids[i].ob = classes[w]
							#print "huh4" +str(w)+"!"+classes[w]
			j = j+1
	global ISCount
	global IVCount
	global IECount
	for centroid in centroids:
		s = centroid.ob
		counter =0
		for p in centroid.pts:
			if (p.id == s):
				counter = counter +1
		if (s == "Iris-virginica"):
			IVCount = counter
			centroid.maxOb = counter
		elif (s == "Iris-setosa"):
			ISCount = counter
			centroid.maxOb = counter
		else:
			IECount = counter
			centroid.maxOb = counter
		print "Centroid: " + centroid.id + " max is: " +str(centroid.maxOb) + " class is: " +centroid.ob
		#print "ISCount "+str(ISCount)+" IVCount " +str(IVCount)+ " IECount "+str(IECount)


def classAvail(w):
	global centroids
	for centroid in centroids:
		if (centroid.ob == w):
			return False
	return True



class Cluster:
	def __init__(self, i, c1, c2, c3, c4, pt, obj,mob):
		self.id = "k"+str(i+1)#+" centroid"
		self.c1 = c1
		self.c2 = c2
		self.c3 = c3
		self.c4 = c4	
		self.pts = pt
		self.ob = obj
		self.maxOb = mob
	def __repr__(self):
		return "Cluser "+self.id+" is this: {0:.2f}".format(self.c1)+"," + "{0:.2f}".format((self.c2))+"," + "{0:.2f}".format(self.c3)+","  + "{0:.2f}".format(self.c4)+"\nPoints: "  +str(self.pts)+"\n"	
    
class Point:
	def __init__(self,c1,c2,c3,c4,cls, clus):
		self.p1=c1
		self.p2=c2
		self.p3=c3
		self.p4=c4
		self.cl=cls
		self.id = clus
	def __repr__(self):
		return str(self.p1)+"," + str(self.p2)+"," + str(self.p3)+"," + str(self.p4)+"," +str(self.cl)

if __name__=="__main__":
	main()


#todo: converges update. set functions. backtracking
