import "cypress-localstorage-commands";
describe("renders the game page", () =>{
    beforeEach(() => {
        cy.login("boriz1", "12345");
      })
      
    it("gets the user table correctly", ()=>{
        cy.visit("/AboutUs")
        cy.get('[href="/users"]').click();
    })

    it("is possible to add another user and view him", ()=>{
        cy.visit("/AboutUs")
        cy.get('[href="/users"]').click();
        cy.get(':nth-child(3) > .btn').click();
        cy.get('[href="/login"]').click();
        cy.get('[href="/register"]').click();
        cy.get(':nth-child(1) > div > .form-control').clear();
        cy.get(':nth-child(1) > div > .form-control').type('cypresstest');
        cy.get(':nth-child(2) > div > .form-control').clear();
        cy.get(':nth-child(2) > div > .form-control').type('cypresstest@gmail.com');
        cy.get(':nth-child(3) > div > .form-control').clear();
        cy.get(':nth-child(3) > div > .form-control').type('123456');
        cy.get(':nth-child(4) > .btn').click();
        cy.get('[href="/login"]').click();
        cy.get(':nth-child(2) > .form-control').clear();
        cy.get(':nth-child(2) > .form-control').type('boriz1');
        cy.get(':nth-child(3) > .form-control').clear();
        cy.get(':nth-child(3) > .form-control').type('12345');
        cy.get('form').click();
        cy.get('form > .btn').click();
        cy.get('[href="/users"]').click();
    })
      
    it("is possible register with a new user", ()=>{
        cy.visit("/AboutUs")
        cy.get(':nth-child(3) > .btn').click();
        cy.get('[href="/register"]').click();
        cy.get(':nth-child(1) > div > .form-control').clear();
        cy.get(':nth-child(1) > div > .form-control').type('cypress');
        cy.get(':nth-child(2) > div > .form-control').clear();
        cy.get(':nth-child(2) > div > .form-control').type('cypress@gmail.com');
        cy.get(':nth-child(3) > div > .form-control').clear();
        cy.get(':nth-child(3) > div > .form-control').type('123456');
        cy.get(':nth-child(4) > .btn').click();
        cy.get('[href="/login"]').click();
        cy.get(':nth-child(2) > .form-control').clear();
        cy.get(':nth-child(2) > .form-control').type('cypress');
        cy.get(':nth-child(3) > .form-control').clear();
        cy.get(':nth-child(3) > .form-control').type('123456');
    })

    it("is possible to change your details", ()=>{
        cy.visit("/AboutUs")

    })

})


// cy.get('.datatable').find('tr').should('have.length', 4)