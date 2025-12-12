$TTL    70000
@               IN      SOA     dnscom.com.    root.dnscom.com. (
                        2024120401 ; serial
                        28800 ; refresh
                        14400 ; retry
                        3600000 ; expire
                        0 ; negative cache ttl
                        )
@                    IN      NS     dnscom.com.
dnscom.com.            IN      A      110.0.10.2

www.com.		IN  A	110.0.5.1

