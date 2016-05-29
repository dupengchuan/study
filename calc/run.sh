#!/bin/bash
time ./calc.sh $1
time ./calc_expr.sh $1
time ./calc_let.sh $1
time ./calc_bc.sh $1
time ./calc_awk.sh $1
