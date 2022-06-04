const a = require('./moudle/a')
const b = require('./moudle/b')

describe('Normal test', () => {
    test('1-1', () => {
        expect(a.printA()).toBe('A')
        expect(a.printB()).toBe('B')
    })
})

describe('doMock A & B', () => {
    beforeAll(() => {
        jest.doMock('./moudle/a', () => ({
            ...jest.requireActual('./moudle/A'),
            printA: jest.fn(() => 'A').mockReturnValueOnce('mock A once')
        }))
        jest.doMock('./moudle/b', () => ({
            printB: jest.fn(() => 'mock B')
        }))
        // Resets the module registry - the cache of all required modules.
        jest.resetModules()
    })
    afterAll(() => {
        jest.dontMock('./moudle/a')
        jest.dontMock('./moudle/b')
        jest.resetModules()
    })
    test('2-1', () => {
        const a = require('./moudle/a')
        expect(a.printA()).toBe('mock A once')
        expect(a.printB()).toBe('mock B')
    })
    test('2-2', () => {
        const a = require('./moudle/a')
        expect(a.printA()).toBe('A')
        expect(a.printB()).toBe('mock B')
    })
})

describe('Check clear doMock test', () => {
    test('2-3', () => {
        const a = require('./moudle/a')
        expect(a.printA()).toBe('A')
        expect(a.printB()).toBe('B')
    })
})

describe('Spy on A & B', () => {
    beforeAll(() => {
        jest.spyOn(a, 'printA')
        jest.spyOn(b, 'printB')
        a.printA.mockReturnValueOnce('spyon A once')
        b.printB.mockReturnValue('spyon B')
    })
    afterAll(() => {
        a.printA.mockRestore()
        b.printB.mockRestore()
    })
    test('3-1', () => {
        expect(a.printA()).toBe('spyon A once')
        expect(a.printB()).toBe('spyon B')
    })
    test('3-2', () => {
        expect(a.printA()).toBe('A')
        expect(a.printB()).toBe('spyon B')
    })
})

describe('Check clear SpyOn test', () => {
    test('3-3', () => {
        expect(a.printA()).toBe('A')
        expect(a.printB()).toBe('B')
    })
})
