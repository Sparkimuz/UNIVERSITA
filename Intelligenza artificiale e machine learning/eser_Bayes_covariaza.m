format short
A=[6.1 6.5 8.8 5.2 0.8
   8.1 1.9 4.2 9.7 5.4]
mi=(1/length(A))*[sum(A(1,:));sum(A(2,:))]
sigma_11=(1/length(A))*sum((A(1,:)-mi(1)).^2)
sigma_22=(1/length(A))*sum((A(2,:)-mi(2)).^2)
sigma_12=(1/length(A))*sum((A(1,:)-mi(1)).*(A(2,:)-mi(2)))
sigma_21=sigma_12
SIGMA=[sigma_11 sigma_12
       sigma_21 sigma_22]
SIGMA=round(SIGMA,1)
mi=round(mi,1)
