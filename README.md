### Restaurant Menu Selection App

This Android application enables customers to order food online for home delivery or store pick-up from a restaurant. The app allows users to choose from various types of food and drinks, following a seamless navigation process through different menus and finally checkout. This app uses Tim Hortons' visual identity.

#### Features:
- **Main Screen**: Displays the restaurant logo and an "Enter" button to begin the ordering process.
- **Menu Selection**: Offers a variety of menu types including Breakfast, Sandwiches, Wraps, Beverages or Drinks, and Desserts & Shakes.
- **Options Menu Control**: Allows users to select different menu types and view available food items with names, prices, and images.
- **Item Selection**: Users can select food items using checkboxes.
- **Checkout Screen**: Displays the selected menu types, food names, and prices. Users can choose from the selected menus using a radio group.
- **Payment Options**: Prompts users to select a payment method (cash, credit card, debit card) using radio buttons.
- **Customer Information**: Collects user details such as full name, address, phone number, and payment information (credit/debit card number, expiry date) with EditText controls and validation.
- **Additional Fields**: Includes custom fields like favorite sport, favorite team, favorite movie/show for additional user information.
- **Persistent Storage**: Uses `SharedPreferences` to store user selections as they navigate through the app.
- **Responsive UI**: Incorporates styles, themes, and drawable objects to create an attractive and user-friendly interface.

### Preview:
<div style="display: flex; justify-content: center;">
  <img src="https://github.com/thuhale2210/tim-horton-ordering-app/assets/120136659/c44c824c-a7b8-495a-abef-7bab7ee20924" alt="tim-horton-order-app-screen1" width="250" height="500" style="margin-right: 20px;">
  <img src="https://github.com/thuhale2210/tim-horton-ordering-app/assets/120136659/1b9e0737-8563-48fb-86f9-d707a514ef85" alt="tim-horton-order-app-screen2" width="250" height="500">
</div>

#### Technologies:
- **Kotlin**: Primary programming language.
- **Android SDK**: Core framework for building the application.
- **SharedPreferences**: For saving and retrieving user selections.
- **UI Elements**: TextView, EditText, RadioGroup, CheckBox, Button, and drawable objects for a polished UI.
- **ConstraintLayout/RelativeLayout**: For flexible and responsive UI design.

#### Getting Started:
1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator.
