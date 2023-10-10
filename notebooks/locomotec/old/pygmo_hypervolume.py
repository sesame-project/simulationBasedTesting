#!/usr/bin/python

import numpy as np
s = "/mnt/ubuntu-home/jharbin/academic/sesame/WP6/notebooks/locomotec/python/condbased_res1000.pf"
front1000 = np.loadtxt(open(s, "rb"), delimiter=",")
hv = hypervolume(front1000)
refpoint = hv.refpoint(offset = 0.1)
hv.compute(refpoint)

#In [20]: hv.compute(refpoint)
#Out[20]: 43444.29967400001
