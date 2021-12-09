import "cypress-localstorage-commands";
describe("renders the game page", () =>{
    // beforeEach(() => {
    //     cy.logInAs3("boriz1", "12345")
    //   })
      
    //   it('check localStorage token', () => {
    //     cy.visit()
    //     expect(localStorage.getItem('accessToken')).not.null
    //     expect(localStorage.getItem('refreshToken')).not.null
    //   })

    // beforeEach(() => {
    //     // reset and seed the database prior to every test
    //     // cy.exec('npm run db:reset && npm run db:seed')
    //     // seed a user in the DB that we can control from our tests
    //     // assuming it generates a random password for us
    //     cy.request('POST', `${Cypress.env('EXTERNAL_API')}login`, { username: 'boriz1', password: "12345" })
    //       .its('body')
    //       .as('currentUser')
    //   })


    it("gets the game container correctly", ()=>{
        cy.visit("/aboutus")

        /* ==== Generated with Cypress Studio ==== */
        cy.get('[href="/login"]').click();
        cy.get(':nth-child(2) > .form-control').clear();
        cy.get(':nth-child(2) > .form-control').type('boriz1');
        cy.get(':nth-child(3) > .form-control').clear();
        cy.get(':nth-child(3) > .form-control').type('12345');
        cy.get('form > .btn').click();
        cy.get('[href="/games"]').click();
        /* ==== End Cypress Studio ==== */
    })
      


})