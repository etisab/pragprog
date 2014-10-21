(defun count-steps (N)
    (cond 
        ((= N 3) 4 ) 
        ((= N 2) 3 )
        ((= N 1) 1 )
        ((<= N 0) 0 )
	(t (+ (count-steps (- N 3)) (count-steps (- N 2)) (count-steps (- N 1))))
    )
)

;example call
(print (count-steps -1))
(print (count-steps 0))
(print (count-steps 1))
(print (count-steps 2))
(print (count-steps 3))
(print (count-steps 4))
(print (count-steps 5))
(print (count-steps 6))
(print (count-steps 7))


