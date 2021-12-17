
describe("renders the about us page", () =>{

    beforeEach(() => {
        cy.login("boriz1","12345");
      });
    
      
    it("renders correctly", ()=>{
        cy.visit("/AboutUs")
        cy.get("#container").should("exist")
    })

    it("allows the button to be clicked", ()=>{
        cy.visit("/AboutUs")
        cy.get('#gamesbutton').click();
    })
})