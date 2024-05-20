## CircuitBreaker - resilience4j:
## Gọi api ItemService từ OrderService:
![image](https://github.com/yennhii134/TranThiYenhi_KT-TKPM_Tuan09/assets/92464791/4927aaaf-b8a2-42a1-9816-c13cb1784dc9)
## Thiết lặp fallBackMethod trong OrderService:
![image](https://github.com/yennhii134/TranThiYenhi_KT-TKPM_Tuan09/assets/92464791/04712f6e-d267-406d-844a-45f00524230a)
## Tắt ItemService và gọi lại api OrderService:
![image](https://github.com/yennhii134/TranThiYenhi_KT-TKPM_Tuan09/assets/92464791/151757b5-74cd-4cef-abb1-b53786b0a80d)
## => Do không get được url nên hàm chạy vào phương thức fallBackMethod

