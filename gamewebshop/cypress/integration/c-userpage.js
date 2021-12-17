
describe("renders the user page", () =>{
    beforeEach(() => {
        cy.login("boriz1", "12345");
      })

      
    it("gets the user table correctly", ()=>{
        cy.visit("/AboutUs")
        cy.get('[href="/users"]').click();
    })

    it("is possible to add another user and view him", ()=>{
        cy.visit("/AboutUs")
        cy.get('#SignOutButton').click();
        cy.get('#registerButton').click();
        cy.get('#registerUsername').clear();
        cy.get('#registerUsername').type('deleteme');
        cy.get('#registerEmail').clear();
        cy.get('#registerEmail').type('1234@gmail.com');
        cy.get('#registerPassword').clear();
        cy.get('#registerPassword').type('123456');
        cy.get('#signUpButton').click();
        cy.get('#loginButton').click();
        cy.get('#usernameInput > .form-control').clear();
        cy.get('#usernameInput > .form-control').type('boriz1');
        cy.get('#passwordInput > .form-control').clear();
        cy.get('#passwordInput > .form-control').type('12345');
        cy.get('form > #loginButton').click();
        cy.get('[href="/users"]').click();
    })
    

    it("is possible to change your details", ()=>{
        cy.visit("/AboutUs")

    })

})


// cy.get('.datatable').find('tr').should('have.length', 4)