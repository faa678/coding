male(baba).
male(didi).
male(gege).
female(mama).
female(jiejie).

husband(baba,mama).
wife(mama,baba).
father(baba,gege).
father(baba,jiejie).
father(baba,didi).
mother(mama,Y) :- father(baba,Y).
son(X,Y) :- father(Y,X),mother(Y,X),male(X).
daugher(X,Y) :- father(Y,X),mother(Y,X),female(X).
sister(X,Y) :- father(baba,X),father(baba,Y),female(X), \+ X=Y.
brother(X,Y) :- father(baba,X),father(baba,Y), male(X), \+ X=Y.
