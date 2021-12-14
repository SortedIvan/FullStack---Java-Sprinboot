describe("renders the about us page", () =>{
    beforeEach(()=>{
        cy.visit("/AboutUs")
        cy.get('[href="/login"]').click();
        cy.get("#loginContainer").should("exist")
        cy.get(':nth-child(2) > .form-control').clear();
        cy.get(':nth-child(2) > .form-control').type('boriz1');
        cy.get(':nth-child(3) > .form-control').clear();
        cy.get(':nth-child(3) > .form-control').type('12345');
        cy.get('form > .btn').click();
    })

    it("renders correctly", ()=>{
        cy.visit("/AboutUs")
        cy.get("#container").should("exist")
    })

    it("allows the button to be clicked", ()=>{
        cy.get('.hero_button__3K5GC').click();
        cy.get("#allGames").should("exist")
    })
})