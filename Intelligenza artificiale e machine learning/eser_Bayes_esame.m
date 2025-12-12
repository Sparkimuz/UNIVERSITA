format short
mi_1=[4.91;-2.02];,mi_2=[2.23;-3];
SIGMA_1_inv=[0.4 0.18    
         0.18 2.23];
SIGMA_2_inv=[0.35 0.17    
         0.17 0.93];
deter_SIGMA_1=1.159678;,deter_SIGMA_2=3.415143;
P_W=[0.4 0.6]';
x=[3.8;-2.4];
d=2;
disp('probabilità condizionate di x dato W')
p_x_W=[(1/((2*pi)^(d/2)*(deter_SIGMA_1)^(0.5)))*exp(-0.5*(x-mi_1)'*SIGMA_1_inv*(x-mi_1))
       (1/((2*pi)^(d/2)*(deter_SIGMA_2)^(0.5)))*exp(-0.5*(x-mi_2)'*SIGMA_2_inv*(x-mi_2))]
disp('probabilità assoluta di x ')
P_x=sum(p_x_W.*P_W)
disp('probabilità a posteriore di W dato x ')
P_W_x=(1/P_x)*(p_x_W.*P_W)

[p_x_W.*P_W]'
max([p_x_W.*P_W]')

