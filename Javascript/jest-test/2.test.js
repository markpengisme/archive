const a = require('./moudle/a')
const b = require('./moudle/b')

jest.mock('./moudle/a', () => ({
    ...jest.requireActual('./moudle/A'),
    printA: jest.fn(() => 'A').mockReturnValueOnce('mock A once')
}))

jest.mock('./moudle/b', () => ({
    printB: jest.fn(() => 'mock B')
}))

describe('Mock A & B in entire test file', () => {
    test('4-1', () => {
        expect(a.printA()).toBe('mock A once')
        expect(a.printB()).toBe('mock B')
    })
    test('4-2', () => {
        expect(a.printA()).toBe('A')
        expect(a.printB()).toBe('mock B')
    })
})
