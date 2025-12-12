format long 
d=2
mi_0=[1.03 1.03]'
sigma_0_inv=[52.56 -10.05;-10.05 36.88]
determinante_sigma_0=0.000544
p_w0=0.6
mi_1=[2.02 1.53]'
sigma_1_inv=[100.58 -22.34;-22.34 37.85]
determinante_sigma_1=0.000302
p_w1=0.4
x=[1.60 1.25]'
disp('probabilità condizionata di x dato w0')%probabilità condizionata di x dato w0
p_x_w0=(1/((2*pi)^(d/2)*(determinante_sigma_0)^(0.5)))*exp(-0.5*(x-mi_0)'*sigma_0_inv*(x-mi_0))
disp('probabilità condizionata di x dato w1')%probabilità condizionata di x dato w1
p_x_w1=(1/((2*pi)^(d/2)*(determinante_sigma_1)^(0.5)))*exp(-0.5*(x-mi_1)'*sigma_1_inv*(x-mi_1))
p_x=0
p_W=[p_w0;p_w1]
p_x_W=[p_x_w0;p_x_w1]
disp('densità di probabilità assoluta dato x')
P_X=sum(p_x_W.*p_W)
disp('probabilità a posteriori di w0 dato x')
p_w0_x=(p_x_w0*p_w0)/P_X
disp('probabilità a posteriori di w1 dato x')
p_w1_x=(p_x_w1*p_w1)/P_X
classi_appartenenza=p_x_W.*p_W
classe_appartenenza=max(p_x_W.*p_W)
indice=0;
for i=1:length(classi_appartenenza)
    if classe_appartenenza==classi_appartenenza(i)
        break 
    end
    indice=indice+1;
end
indice





