# RiskCheck/Crypto Risk Analyzer

RiskCheck/Crypto Risk Analyzer is a Java-based application that fetches real-time cryptocurrency data from the CoinGecko API and calculates a risk score for each cryptocurrency based on various metrics such as market capitalization, trading volume, and current price. The higher the risk score, the more volatile or speculative the asset is considered to be.

## Features
- Fetches real-time cryptocurrency data using the CoinGecko API.
- Calculates risk scores for cryptocurrencies based on the data retrieved.
- Outputs a list of cryptocurrencies along with their corresponding risk scores.
- Built with Maven for dependency management.

## Technologies Used
- Java 23
- Maven 3.9.9
- Apache HttpClient 5 for making API requests
- Jackson for parsing JSON data

## How Risk Is Calculated
The risk score is calculated based on a basic algorithm that considers the following factors:
- **Market Capitalization**: Cryptocurrencies with smaller market caps are considered riskier.
- **Trading Volume**: Higher volume generally indicates lower risk, as there is more liquidity.
- **Price Volatility (Future Improvement)**: Not yet implemented, but this will consider how much the price fluctuates over time.
- **Hype or Sentiment (Future Improvement)**: Analysis of social media or news trends can give insights into public sentiment.

## Understanding the Risk Score
Risk Score: This is a numeric value that represents the relative risk level of a cryptocurrency. The higher the score, the higher the perceived risk.
Low Risk: Scores closer to 1 represent low-risk investments. These could be well-established cryptocurrencies with large market capitalization and stable price behavior, such as Bitcoin or Ethereum.
Medium Risk: Scores between 1 and 10 might indicate moderate risk, representing cryptocurrencies with some degree of price volatility or smaller market capitalization.
High Risk: Scores above 10 represent highly volatile, speculative, or newly introduced cryptocurrencies that could present more significant risks due to their price fluctuations, low liquidity, or lack of established usage.

The score is computed based on simple rules for now:
- Cryptocurrencies with a very small market cap and low volume might receive higher risk scores.
- Well-established cryptocurrencies like Bitcoin and Ethereum generally have lower risk scores.

## Author
- Bikram Jeet Singh
- GitHub: heybikramjeetsingh
- Email: heybikramjeetsingh@gmail.com
