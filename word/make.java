1	package
1	makeFile
1	;
3	import
3	java
3	sql
3	Timestamp
3	;
4	import
4	java
4	text
4	SimpleDateFormat
4	;
5	import
5	java
5	util
5	Date
5	;
6	import
6	java
6	util
6	Random
6	;
8	public
8	class
8	make
8	{
9	long
9	rowid
9	=
9	0
9	;
10	public
10	String
10	makeRow
10	(
10	)
10	{
12	Byte
12	b
12	=
12	new
12	Byte
12	16
12	;
13	rowid
13	++
13	;
14	Date
14	da
14	=
14	new
14	Date
14	(
14	)
14	;
15	Timestamp
15	time
15	=
15	new
15	Timestamp
15	(
15	da
15	getTime
15	(
15	)
15	)
15	;
16	SimpleDateFormat
16	df
16	=
16	new
16	SimpleDateFormat
16	(
16	"
16	yyyy
16	-
16	mm
16	-
16	dd
16	hh24
16	mm
16	ss
16	SSSSSSS
16	"
16	)
16	;
17	String
17	st
17	=
17	df
17	format
17	(
17	time
17	)
17	toString
17	(
17	)
17	;
18	//
19	Random
19	ai
19	=
19	new
19	Random
19	(
19	7
19	)
19	;
20	String
20	mobile
20	=
20	"
20	186
20	"
20	+
20	Radom
20	(
20	8
20	10
20	)
20	;
21	String
21	lac
21	=
21	mRadom
21	(
21	5
21	10
21	)
21	;
22	String
22	cell
22	=
22	mRadom
22	(
22	5
22	10
22	)
22	;
23	String
23	imei
23	=
23	mRadom
23	(
23	15
23	10
23	)
23	;
24	String
24	flow_type
24	=
24	mRadom
24	(
24	3
24	10
24	)
24	;
25	String
25	start_time
25	=
25	st
25	;
27	String
27	duration
27	=
27	"
27	1
27	"
27	;
28	String
28	upload
28	=
28	"
28	164
28	"
28	;
29	String
29	download
29	=
29	"
29	156
29	"
29	;
30	String
30	total_byte
30	=
30	"
30	320
30	"
30	;
31	String
31	rat_type
31	=
31	"
31	1
31	"
31	;
32	String
32	ip
32	=
32	"
32	10
32	"
32	+
32	"
32	+
32	Radom
32	(
32	2
32	9
32	)
32	+
32	"
32	+
32	Radom
32	(
32	2
32	9
32	)
32	+
32	"
32	+
32	Radom
32	(
32	2
32	9
32	)
32	;
33	String
33	access_ip
33	=
33	mRadom
33	(
33	2
33	9
33	)
33	+
33	"
33	+
33	Radom
33	(
33	2
33	9
33	)
33	+
33	"
33	+
33	Radom
33	(
33	2
33	9
33	)
33	+
33	"
33	+
33	Radom
33	(
33	2
33	9
33	)
33	;
34	String
34	status
34	=
34	"
34	0
34	"
34	;
35	String
35	user_agent
35	=
35	"
35	0
35	"
35	;
36	String
36	apn
36	=
36	"
36	3
36	gnet
36	"
36	;
37	String
37	imsi
37	=
37	"
37	46001
37	"
37	+
37	Radom
37	(
37	10
37	9
37	)
37	;
38	String
38	sgsn_ip
38	=
38	"
38	220
38	"
38	+
38	"
38	+
38	Radom
38	(
38	2
38	9
38	)
38	+
38	"
38	+
38	Radom
38	(
38	2
38	9
38	)
38	+
38	"
38	+
38	Radom
38	(
38	2
38	9
38	)
38	;
39	String
39	ggsn_ip
39	=
39	"
39	220
39	"
39	+
39	"
39	+
39	Radom
39	(
39	2
39	9
39	)
39	+
39	"
39	+
39	Radom
39	(
39	2
39	9
39	)
39	+
39	"
39	+
39	Radom
39	(
39	2
39	9
39	)
39	;
40	String
40	content_type
40	=
40	"
40	application
40	/
40	json
40	;
40	charset
40	=
40	utf
40	-
40	8
40	"
40	;
41	String
41	source_port
41	=
41	"
41	49
41	"
41	+
41	Radom
41	(
41	3
41	9
41	)
41	;
42	String
42	dest_port
42	=
42	"
42	80
42	"
42	;
43	String
43	record_type
43	=
43	"
43	0
43	"
43	;
44	long
44	flag
44	=
44	Thread
44	currentThread
44	(
44	)
44	getId
44	(
44	)
44	;
45	long
45	a
45	=
45	{
45	rowid
45	flag
45	}
45	;
46	//
47	//
48	String
48	url
48	=
48	"
48	http
48	//
49	Date
49	dt
49	=
49	new
49	Date
49	(
49	)
49	;
50	String
50	end_time
50	=
50	df
50	format
50	(
50	dt
50	)
50	toString
50	(
50	)
50	;
52	return
52	mobile
52	+
52	|
52	"
52	+
52	ac
52	+
52	|
52	"
52	+
52	ell
52	+
52	|
52	"
52	+
52	mei
52	+
52	|
52	"
52	+
52	low_type
52	+
52	|
52	"
52	+
52	tart_time
52	+
52	|
52	"
52	+
52	nd_time
52	+
52	|
52	"
52	+
52	uration
52	+
52	|
52	"
52	+
52	pload
52	+
52	|
52	"
52	+
52	ownload
52	+
52	|
52	"
52	+
52	otal_byte
52	+
52	|
52	"
52	+
52	at_type
52	+
52	|
52	"
52	+
52	p
52	+
52	|
52	"
52	+
52	ccess_ip
52	+
52	|
52	"
52	+
52	tatus
52	+
52	|
52	"
52	+
52	ser_agent
52	+
52	|
52	"
52	+
52	pn
52	+
52	|
52	"
52	+
52	msi
52	+
52	|
52	"
52	+
52	gsn_ip
52	+
52	|
52	"
52	+
52	gsn_ip
52	+
52	|
52	"
52	+
52	ontent_type
52	+
52	|
52	"
52	+
52	ource_port
52	+
52	|
52	"
52	+
52	est_port
52	+
52	|
52	"
52	+
52	ecord_type
52	+
52	|
52	"
52	+
52	rl
52	+
52	r
52	n
52	"
52	;
53	//
55	}
56	public
56	String
56	mRadom
56	(
56	int
56	sum
56	int
56	n
56	)
57	{
58	String
58	prnum
58	=
58	"
58	"
58	;
59	for
59	(
59	int
59	i
59	=
59	0
59	;
59	i
59	<
59	sum
59	;
59	i
59	++
59	)
60	{
61	Random
61	r
61	=
61	new
61	Random
61	(
61	)
61	;
62	int
62	ai
62	=
62	r
62	nextInt
62	(
62	n
62	)
62	;
63	prnum
63	+=
63	ai
63	;
64	}
65	return
65	prnum
65	;
66	}
68	}
总行数	69	无效行数5
