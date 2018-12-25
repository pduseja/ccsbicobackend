const constants = {
    title: [
        {
            value: 'mr',
            label: 'Mr',
        },
        {
            value: 'mrs',
            label: 'Mrs',
        },
        {
            value: 'miss',
            label: 'Miss',
        },
        {
            value: 'ms',
            label: 'Ms',
        },
        {
            value: 'dr',
            label: 'Dr',
        }],
    question: [
        {
            value: 1,
            label: "What is your mother's maiden name?"
        },
        {
            value: 2,
            label: "What is your childhood School name?"
        },
        {
            value: 3,
            label: "Which place you like visiting again & again?"
        },
        {
            value: 4,
            label: "Who is your best friend?"
        },
        {
            value: 5,
            label: "What is your pet name?"
        }],
    menuItems:
        {
            links: [{
                text: 'Home',
                name: 'home',
                link: '/',
            }, {
                text: 'About us',
                name: 'aboutus',
                link: '/',
                submenu: [{
                    text: 'About us'
                }, {
                    text: 'What we do'
                }, {
                    text: 'Team'
                }, {
                    text: 'Pricing'
                }, {
                    text: 'FAQs'
                }]
            }, {
                text: 'Services',
                name: 'services',
                submenu: [{
                    text: 'Educational Support Services'
                }, {
                    text: 'Care Support Services'
                }, {
                    text: 'Business Support Services'
                }, {
                    text: 'Operations Management'
                }, {
                    text: 'Information Tech Services'
                }]
            }, {
                text: 'Our partners',
                name: 'ourpartners',
                submenu: [{
                    text: 'Citizens'
                }, {
                    text: 'Small businesses'
                }, {
                    text: 'CCSBI Families'
                }, {
                    text: 'Franchises'
                }, {
                    text: 'Other stakeholders'
                }]
            }, {
                text: 'Service & Product Search',
                name: 'search',
                submenu: [{
                    text: 'Service & Product Search'
                }, {
                    text: 'Our approach'
                }, {
                    text: 'Help: How it Works'
                }, {
                    text: 'Write your need'
                }, {
                    text: 'Additional information'
                }]
            },{
                text: 'Charity Options',
                name: 'charityoptions'
            }, {
                text: 'Opinion polls',
                name: 'opinionpolls'
            }, {
                text: 'Contact us',
                name: 'contactus',
            }
            ]
        },
    rightMenu:
        {
            items: {
                text: 'Menu Details'
            }
        }


};
export default constants;