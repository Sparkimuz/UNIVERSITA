
p=[4.61 2.18 3.84]'
d=3
mi_1=[3.27 2.21 4.23]'
mi_2=[2.79 3.58 1.64]'
mi_3=[5.79 3.05 2.83]'
A=eye(3,3)
a_1=sum((p-mi_1).^2)
a_2=sum((p-mi_2).^2)
a_3=sum((p-mi_3).^2)
a=[a_1 a_2 a_3]'
disp('probabilità condizionale di p dato w_i')
prob_p_W=(1/((2*pi)^(d/2)))*exp(-0.5*a)
prob_W=[1/3 1/3 1/3]'
disp('densità di probabilità assoluta dato x')
P=sum(prob_p_W.*prob_W)

prob_W_p=(prob_p_W.*prob_W)/P
B=prob_p_W.*prob_W
B_scelto=max(B)