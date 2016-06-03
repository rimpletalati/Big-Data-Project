f = open('user.txt', 'r');

lines = f.readlines()

list_res = []


for line in lines:
	line_1 = line.split('\n')
	id = line_1[0]
	id = id.replace('-', '')
	list_res.append(id)

f = open('useroutput', 'w')

for line in list_res:
	f.write(line + '\n')

f.close()
print ('Done')




