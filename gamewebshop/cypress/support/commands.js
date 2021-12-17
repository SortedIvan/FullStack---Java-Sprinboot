
import "cypress-localstorage-commands";
// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })
// let LOCAL_STORAGE_MEMORY = {};

// Cypress.Commands.add("saveLocalStorageCache", () => {
//   Object.keys(localStorage).forEach(key => {
//     LOCAL_STORAGE_MEMORY[key] = localStorage[key];
//   });
// });

// Cypress.Commands.add("restoreLocalStorageCache", () => {
//   Object.keys(LOCAL_STORAGE_MEMORY).forEach(key => {
//     localStorage.setItem(key, LOCAL_STORAGE_MEMORY[key]);
//   });
// });

// Cypress.Commands.add("clearLocalStorageCache", () => {
//     localStorage.clear();
//     LOCAL_STORAGE_MEMORY = {};
//   });


// Cypress.Commands.add('loginAs', (Username, UserPwd) => {
//   cy.request({
//     method: 'POST',
//     url: "/api/login",
//     body: {
//       user: {
//         username: Username,
//         password: UserPwd,
//       }
//     }
//   })
//     .its('body')
//     .then((body) => {
//       cy.setLocalStorage("accessToken", body.accessToken);
//       cy.setLocalStorage("refreshToken", body.refreshToken);
//     });
// });

// Cypress.Commands.add('logInAs3', (Useremail, Userpwd) => {
//     cy.request({
//       method: 'POST',
//       url: `${Cypress.env('EXTERNAL_API')}login`,
//       body: {
//         user: {
//           username: Useremail,
//           password: Userpwd,
//         }
//       }
//     })
//       .its('body')
//       .then((body) => {
//         window.localStorage.setItem('accessToken', body.data.data.accessToken);
//         window.localStorage.setItem('refreshToken', body.data.data.accessToken);
//       })
//   });

Cypress.Commands.add('login', (username, password) => {
  var reqBody = "username="+username+"&password="+password+"&grant_type=password";
      cy.request({
          method: 'POST',
          url: 'http://localhost:8080/api/login',
          headers:{
              'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
          },
          body: reqBody
        }).then(({ body }) => {
          window.localStorage.setItem("user", JSON.stringify(body))
  })
})