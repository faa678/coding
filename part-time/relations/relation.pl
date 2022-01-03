male(yeye).
male(baba).
male(didi).
male(gege).
female(nainai).
female(mama).
female(jiejie).

husband(yeye,nainai).
husband(baba,mama).
wife(nainai,yeye).
wife(mama,baba).
father(yeye,baba).
father(yeye,mama).
father(baba,gege).
father(baba,jiejie).
grandfather(yeye,gege).
grandfather(yeye,jiejie).
grandfather(yeye,didi).
father(baba,didi).
grandmother(nainai,gege).
grandmother(nainai,jiejie).
grandmother(nainai,didi).
mother(mama,Y) :- father(baba,Y).
son(X,Y) :- father(Y,X),mother(Y,X),male(X).
daugher(X,Y) :- father(Y,X),mother(Y,X),female(X).
sister(X,Y) :- father(baba,X),father(baba,Y),female(X), \+ X=Y.
brother(X,Y) :- father(baba,X),father(baba,Y), male(X), \+ X=Y.
